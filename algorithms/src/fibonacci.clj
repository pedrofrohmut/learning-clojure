;; fibonacci.clj
;; Pedro Frohmut 2026 Copyrights

(defn fibo
  "Makes a fibonacci sequence up to a limit number"
  ([limit]

   (def result (fibo limit 1 1 [1 1]))
   (println (str "Fibonacci limit of " limit " is " result))
   )

  ([limit a b acc]

   (def next-num (+ a b))

   (if (> next-num limit)
     acc
     (fibo limit b next-num (conj acc next-num))
     )
   )
  )

(fibo 10)
(fibo 50)
(fibo 100)
(fibo 300)
