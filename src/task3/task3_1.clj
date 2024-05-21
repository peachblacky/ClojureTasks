(ns task3.task3-1
  (:require [task3.test-functions :as tfun]
           [task3.integral-computation :as ic])
  )

(print "Time measurements:\n")
(time (ic/integral-default tfun/test-function-polynomial -70 70 0.05))

(print "Memoize elapsed times: \n")
(let [fun (ic/integral-mem tfun/test-function-polynomial 0.05)]
 (time (fun -70 70))
(time (fun -70 70))
(time (fun -70 70)))

