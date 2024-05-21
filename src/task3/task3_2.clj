(ns task3.task3-2
  (:require [task3.test-functions :as tfun]
            [task3.integral-computation :as ic])
  )


(print ((ic/integral-inf tfun/test-function-polynomial 0.05) 15))
