(ns task1.task1-4
  (:require [task1.task1-3 :as fm]))

(defn append-char
  "Appends letter to a word"
  [word symbol]
  (if (= (str (last word)) symbol)
    nil
    (str word symbol)))

(defn append-sequence
  "Return all possible one-character extensions of sequence"
  [sequence alphabet]
  (fm/my-filter some? (fm/my-map #(append-char sequence %1) alphabet)))

(defn append-sequences
  "Iterate over sequences and expand each of them with characters from alphabet"
  [sequences alphabet]
  (reduce #(into %1 (append-sequence %2 alphabet)) `() sequences))

(defn solve
  "Returns all sequences of length n constructed from characters of alphabet"
  [alphabet n]
  (if (empty? alphabet)
    `()
    (reduce (fn [acc _] (fm/my-filter #(= (count %1) n) (if (empty? acc) alphabet (append-sequences acc alphabet)))) [] (range 0 n))))

(println (solve `("a" "b" "c") 2))