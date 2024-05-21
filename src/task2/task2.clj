(ns task2.task2)

(declare primes)

(defn prime?
  [x]
  (let [test-factors (fn [x] (take-while #(<= (* % %) x) primes))]
    (every? #(pos? (mod x %)) (test-factors x))))

(def primes
  (cons 2
        (for [x (iterate inc 3)
              :when (prime? x)]
          x)))

(print (nth primes 100000))