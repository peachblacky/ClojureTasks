(ns task1.task1-2)

(defn append-char
  "Appends letter to a word"
  [word symbol]
  (if (= (str (last word)) symbol)
    nil
    (str word symbol)))

(defn append-sequence
  "Return all possible one-character extensions of sequence"
  [sequence alphabet seq-acc]
  (if (empty? alphabet)
    seq-acc
    (let [new-word (append-char sequence (first alphabet))
          new-seq (rest alphabet)]
      (if (nil? new-word)
        (recur sequence new-seq seq-acc)
        (recur sequence new-seq (into seq-acc (list new-word)))))))

(defn append-sequences
  "Iterate over sequences and expand each of them with characters from alphabet"
  [sequences alphabet seq-acc]
  (if (empty? sequences)
    seq-acc
    (recur (rest sequences) alphabet (into seq-acc (append-sequence (first sequences) alphabet [])))))

(defn solve
  "Returns all sequences of length n constructed from characters of alphabet"
  [seq-acc alphabet n]
  (if (empty? alphabet)
    `()
    (if (empty? seq-acc)
      (solve alphabet alphabet n)
      (if (= (count (first seq-acc)) n)
        seq-acc
        (recur (append-sequences seq-acc alphabet []) alphabet n)))))

(println (solve [] `("a" "b" "c") 3))