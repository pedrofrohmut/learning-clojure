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

(defn factorial-reducer
  [acc curr]

  (conj acc (factorial curr))
  )

(defn factorial-range
  [start end]

  (reduce factorial-reducer [] (range start (+ 1 end)))
  )

(factorial-range 1 10)

(defn fact
  "Returns the factorial of n"
  [n]

  (defn reducer [acc curr] (* acc curr))
  (def arr (range 1 (+ n 1)))
  (reduce reducer 1 arr)
  )

(assert (= (fact 3) 6)
        "Fact of 3 should be 6")

(assert (= (fact 5) 120)
        "Fact of 5 should be 120")

(assert (= (fact 6) 720)
        "Fact of 6 should be 720")
