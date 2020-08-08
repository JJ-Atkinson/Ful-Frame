(ns dev.freeformsoftware.dependency-graphs.algorithms.diff-test
  (:require [clojure.test :refer :all]
            [dev.freeformsoftware.dependency-graphs.algorithms.diff :refer :all]
            [dev.freeformsoftware.metacomet.testing-utils :as mc.tu]
            ))


(def db {:a-- {:-a- {:--a 1
                     :--b 2}
               :-b- {:--c 3
                     :--d 4}
               5    {#{:--a} {:cool :is :here :now}
                     '--b    [#{'a} #{'b}]}}
         :b-- {:-a- 5
               :-b- [5]}
         :c-- :value})

(deftest test-walk-diff-maps
  (testing ""))

(deftest test-quick-diff
  (testing "that all 3 levels are checked"
    #_(is (= (quick-diff db (assoc-in db [:a-- :-a- :--a] 2))
          #{[:a-- :-a- :--a]}))))
