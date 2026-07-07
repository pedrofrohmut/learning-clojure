;; Pedro Frohmut 2026 Copyrights

(defn factorial
  [n]

  (if (<= n 1)
    1
    (* n (factorial (- n 1)))
    )
  )

(assert (= (factorial 0) 1) "factorial of 0 should be 1")
(assert (= (factorial 1) 1) "factorial of 1 should be 1")
(assert (= (factorial 5) 120) "factorial of 5 should be 120")
