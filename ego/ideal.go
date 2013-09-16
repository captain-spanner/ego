package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

import (
	"go/ast"
	"math/big"
)

type Ideal struct {
	Op Ideals
	Literal *ast.BasicLit
	Int *big.Int
	Float float64
}

type Ideals byte

const (
	Ixxxx Types = iota

	Iint
	Ifloat
)
