(ns task3.test-functions)

(defn test-function-linear [x] (* 5 x))
(defn test-function-parabola [x] (* x x))
; f(x)=x^4 - 17x^2 + 5x + 4
(defn test-function-polynomial [x] (+ (- (* (* (* x x) x) x) (* 17 (* x x))) (* 5 x) 4))
