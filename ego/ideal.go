package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

type Ideal struct {
	Op Ideals
	Text string
	Data interface {}
}

type Ideals byte

const (
	Ixxxx Types = iota

	Iint
	Ifloat
)
