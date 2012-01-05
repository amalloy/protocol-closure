(ns protocol.core)

(defprotocol Typed
  (typename [this]
    "A string describing the thing's type"))

;; imagine this is provided by the base library
(extend-type Number Typed (typename [this] "number"))

;; this only works for types already extended to the protocol
(def type-key1 (comp keyword typename))

;; this works for types which are later extended
(defn type-key2 [obj]
  (keyword (typename obj)))

;; imagine this is provided by someone extending the library
(extend-type String Typed (typename [this] "string"))
