package ego

//
//	Copyright(C) 2013 Bruce Ellis. All rights reserved.
//	No unauthorized commercial use permitted.
//

import (
	"fmt"
	"go/printer"
	"os"
)

func Bomb(s string) {
	panic(s)
}

func Dump(node interface{}) {
	printer.Fprint(os.Stdout, Cfg.Package.FileSet, node)
	fmt.Println()
}
