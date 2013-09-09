package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

type Type struct {
	Op	Types
	Sub	*Type
	Index	*Type	// or Recv
	Args	*Type
	Ret	*Type
	Size	int
	Name	string
}

type Types byte

const (
	Txxxx Types = iota

	base_begin
	Tint8
	Tuint8
	Tint16
	Tuint16
	Tint32
	Tuint32
	Tint64
	Tuint64
	Tfloat32
	Tfloat64
	Tcomplex64
	Tcomplex128

	Tbool
	Tideal
	Tnil
	Tstring
	base_end

	Tarray
	Tchan
	Tfunc
	Tptr
	Tslice
	Tstruct
	Ttype

	Tlist
)

// types are interned in three maps.
//   base types
//   derived types
//   named types
// type equality is pointer equality.
// lists (args, rets) are lists, creating suffix trees.
var (
	btypes		map[Types]*Type
	dtypes		map[Type]*Type
	ntypes		map[string]*Type
	typeBool	*Type
	typeIdeal	*Type
	typeString	*Type
)

func init() {
	btypes = make(map[Types]*Type)
	dtypes = make(map[Type]*Type)
	ntypes = make(map[string]*Type)
	for b := base_begin + 1; b < base_end; b++ {
		t := new(Type)
		t.Op = b
		btypes[b] = t
	}
	typeBool = btypes[Tbool]
	typeIdeal = btypes[Tideal]
	typeString = btypes[Tstring]
}

// derived type interning
// subtypes must be interned
func (t *Type) FindType() *Type {
	r, have := dtypes[*t]
	if !have {
		dtypes[*t] = t
		r = t
	}
	return r
}

func (s *Type) DeriveType(b Types) *Type {
	t := new(Type)
	t.Op = b
	t.Sub = s
	return t.FindType()
}

func (s *Type) ChanOf() *Type {
	return s.DeriveType(Tchan)
}

func (s *Type) PtrTo() *Type {
	return s.DeriveType(Tptr)
}

func (s *Type) SliceOf() *Type {
	return s.DeriveType(Tslice)
}
