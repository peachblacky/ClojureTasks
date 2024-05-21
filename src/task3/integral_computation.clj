(ns task3.integral-computation)

(defn trapezoid-area [f a b]
  (* (* (+ (f a) (f b)) (- b a)) 0.5))

(defn integral-default [f a b h]
  (if (< a b)
    (+
      (trapezoid-area f a (+ a h))
      (integral-default f (+ a h) b h))
    0))

(defn integral-mem [f h]
  (memoize (fn compute [a b]
             (if (< a b)
               (+ (trapezoid-area f a (+ a h)) (compute (+ a h) b))
               0)
             )
           )
  )

(defn integral-inf [function step_size]
  (let [seq (map first
                 (iterate
                   (fn [[step_sum index]]
                     [
                      (+ step_sum (trapezoid-area function (* step_size (- index 1)) (* step_size index)))
                      (inc index)
                      ]
                     )
                   [0 1])
                 )]
    (fn [x]
      (let [i (int (/ x step_size))]
        (+ (nth seq i) (trapezoid-area function (* step_size i) x))
        )
      )
    )
  )