(ns dev.freeformsoftware.dependency-graphs.algorithms.indexing-scratch*
  (:require [com.fulcrologic.fulcro.algorithms.indexing :as fidx]
            [com.fulcrologic.fulcro.components :as comp]
            [com.fulcrologic.fulcro.algorithms.denormalize :as dnz]
            [edn-query-language.core :as eql]))

(comp/defsc Child [_ _]
  {:query [:chi/a
           :chi/b]
   :ident :chi/a})


(comp/defsc ChildNID [_ _]
  {:query [:chi-nid/a
           {:chi-nid/b [:...]}
           :par/a]})

(comp/defsc Parent [_ _]
  {:query [:par/a
           {:par/b []}
           {:par/c (comp/get-query ChildNID)}
           {:par/d (comp/get-query Child)}]
   :ident :par/a})

(comp/defsc ParentNID [_ _]
  {:query [:par-nid/a
           {:par-nid/b [:...]}
           {:par-nid/c (comp/get-query ChildNID)}
           {:par-nid/d (comp/get-query Child)}
           {:par/d (comp/get-query Child)} ;; what happens when the same key is used twice?
           ]})


(comment
  (fidx/index-query [:comp/id
                     {:comp/childs [:child/id :child/w]}])
  (fidx/index-query (comp/get-query ParentNID))
  (fidx/index-query (comp/get-query Parent)))


