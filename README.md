# protocol-closure

The issue here appears to be that protocol functions get mutated when a new implementing type is
added. For example:

    user=> (defprotocol Foo (foo [this]))
    Foo
    user=> foo
    #<user$eval75$fn__76$G__66__81 user$eval75$fn__76$G__66__81@28ae4646>
    user=> (extend-type String Foo (foo [this] "x"))
    nil
    user=> foo
    #<user$eval75$fn__76$G__66__81 user$eval75$fn__76$G__66__81@6f03de90>

Note that the `foo` function has the same class but is a different instance - presumably it's
closing over a different set of implementations or something. But this means that if you evaluate a
protocol function before extending some types to it, the version you evaluate&save will not respect
the implementations added since then. See the [source](./src/protocol/core.clj) for an example,
where a desire to use closures and HOFs leads to unexpected behavior (the errors seen in the
[tests](./test/protocol/core_test.clj)).

## Usage

FIXME

## License

Copyright (C) 2011 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
