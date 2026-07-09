;; fibonacci.clj
;; Pedro Frohmut 2026 Copyrights

(defn fibo
  "Makes a fibonacci sequence up to a limit number"
  ([limit]

   (def result (fibo limit 1 1 [1 1]))
   ;; (println (str "Fibonacci limit of " limit " is " result))
   result
   )

  ([limit a b acc]

   (def next-num (+ a b))

   (if (> next-num limit)
     acc
     (fibo limit b next-num (conj acc next-num))
     )
   )
  )

(def limit 100)
(def expected [1 1 2 3 5 8 13 21 34 55 89])
(def result (fibo limit))
(assert
 (= expected result)
 (format "Expected fibonacci of %d result to be %s but got %s instead" limit expected result)
 )
