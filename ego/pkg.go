package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

import (
	"fmt"
	"go/ast"
	"go/parser"
	"go/token"
	"os"
)

var Cfg Ego = Ego{
	PkgDir:   "/usr/local/go/src/pkg",
	JavaDir:  "/home/brucee/go/src/github.com/captain-spanner/efe/java",
	JavaPkg:  "com.chunder.ego",
	JavaPath: "com/chunder/ego",
}

type Ego struct {
	PkgDir   string
	JavaDir  string
	JavaPkg  string
	JavaPath string
}

type Pkg struct {
	Name    string
	Path    string
	FileSet *token.FileSet
	File    *ast.File
	Decls   []*ast.GenDecl
	Funcs   []*ast.FuncDecl
}

func ParsePkg(dir string, name string) (pkg *Pkg, err error) {
	fset := token.NewFileSet()
	path := Cfg.PkgDir + "/" + dir
	pkgmap, err := parser.ParseDir(fset, path, pkgFilter, 0)
	if err != nil {
		return
	}
	for pname, past := range pkgmap {
		if name == pname {
			pkg = new(Pkg)
			pkg.Name = name
			pkg.Path = path
			pkg.FileSet = fset
			pkg.File = ast.MergePackageFiles(past, ast.FilterImportDuplicates)
			pkg.findFuncs()
			return pkg, nil
		}
	}
	return nil, fmt.Errorf("package %s not found", name)
}

func pkgFilter(info os.FileInfo) bool {
	n := info.Name()
	l := len(n)
	if l <= 3 || n[l-3:] != ".go" {
		return false
	}
	if l > 8 && n[l-8:] == "_test.go" {
		return false
	}
	return true
}

func (pkg *Pkg) findFuncs() {
	decls := pkg.File.Decls
	v, f := 0, 0
	for _, decl := range decls {
		switch decl.(type) {
		case *ast.GenDecl:
			v++
		case *ast.FuncDecl:
			f++
		}
	}
	vs := make([]*ast.GenDecl, v)
	fs := make([]*ast.FuncDecl, f)
	v, f = 0, 0
	for _, decl := range decls {
		switch d := decl.(type) {
		case *ast.GenDecl:
			vs[v] = d
			v++
		case *ast.FuncDecl:
			fs[f] = d
			f++
		}
	}
	pkg.Decls = vs
	pkg.Funcs = fs
	for _, fn := range fs {
		if fn.Body != nil {
			cvtStmts(fn.Body.List)
		}
	}
}
