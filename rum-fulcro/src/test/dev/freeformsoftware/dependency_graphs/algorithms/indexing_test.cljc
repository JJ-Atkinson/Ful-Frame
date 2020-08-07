(ns dev.freeformsoftware.dependency-graphs.algorithms.indexing-test
  (:require [clojure.test :refer :all]
            [dev.freeformsoftware.dependency-graphs.algorithms.indexing :refer :all]
            [dev.freeformsoftware.metacomet.testing-utils :as mc.tu]
            ))









#_(deftest test-transitive-sorted
  (testing "graph 1 - no pre-provided deps"
    (are [req maybe-mult-deps] (check-is-opt req maybe-mult-deps)
                               #{:b} [:a :b]
                               #{:e} [:a :b :e]
                               #{:c} [:a :d :c]
                               #{:f} [:a :d :c :f]
                               #{:g} [:a :d :g]
                               #{:g :d} [:a :d :g]
                               #{:f :g} #{[:a :d :c :g :f]
                                          [:a :d :c :f :g]} ; just cuz sets are random ordered. Still works.
                               #{:g :f} #{[:a :d :c :g :f]
                                          [:a :d :c :f :g]}
                               #{:h :d} #{[:a :d :c :f :g :h]
                                          [:a :d :c :f :h :g]}
                               #{:d :h} #{[:a :d :c :f :g :h]
                                          [:a :d :c :f :h :g]}
                               ))
  (testing "graph 1 - pre-provided deps"
    (are [req pre-provided maybe-mult-deps]
      (check-is-opt req pre-provided maybe-mult-deps)
      #{:b} #{} [:a :b]                 ;; default behavior is good
      #{:e} #{:b} [:e]
      #{:c} #{:a} [:d :c]
      #{:f} #{:d} [:a :c :f]
      #{:g} #{} [:a :d :g]
      #{:g :d} #{} [:a :d :g]
      #{:f :g} #{:c} #{[:a :d :g :f]
                       [:a :d :c :f :g]} ; just cuz sets are random ordered. Still works.
      #{:g :f} #{:d} #{[:a :c :g :f]
                       [:a :c :f :g]}
      #{:h :d} #{:f :a} #{[:d :g :h]
                          [:d :h :g]}
      #{:d :h} #{} #{[:a :d :c :f :g :h]
                     [:a :d :c :f :h :g]}
      )))