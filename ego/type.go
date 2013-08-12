package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

type Type struct {
	Op Types
	Sub *Type
	Data interface {}
	Load interface {}
}

type Types byte

const (
	Txxxx Types = iota

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

	Tideal
)
