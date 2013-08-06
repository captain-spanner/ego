package main

import (
	"bytes"
	"fmt"
	"go/printer"

	"github.com/captain-spanner/ego"
)

func main() {
	pkg, err := ego.ParsePkg("bytes", "bytes")
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(len(pkg.Decls), len(pkg.Funcs))
	for _, decl := range pkg.Decls {
		var buf bytes.Buffer
		printer.Fprint(&buf, pkg.FileSet, decl)
		// fmt.Println(buf.String())
	}
}
