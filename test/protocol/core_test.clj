(ns protocol.core-test
  (:use clojure.test
        protocol.core))

(deftest test-typekey1
  (is (= :string (type-key1 "foo")))
  (is (= :number (type-key1 10))))

(deftest test-typekey2
  (is (= :string (type-key2 "foo")))
  (is (= :number (type-key2 10))))