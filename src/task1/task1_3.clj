(ns task1.task1-3)

(defn my-map
  [function collection]
  (seq (reduce #(conj %1 (function %2 )) [] collection)))

(defn my-filter
  [predicate collection]
  (seq (reduce #(if (predicate %2) (conj %1 %2) %1) [] collection)))

;(println (my-map inc `(3 2 2 8)))
;(println (my-filter odd? `(1 2 3 4 5)))