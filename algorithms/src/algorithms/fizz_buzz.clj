;; Pedro Frohmut 2026 Copyrights

(defn fizz-buzz
  [n]

  (doseq [x (range 1 n)]
    (cond
      (= 0 (mod x 15))  (print " FizzBuzz")
      (= 0 (mod x 5))   (print " Buzz")
      (= 0 (mod x 3))   (print " Fizz")
      :else (print " " x)
      )
    )
  (println)
  )

(fizz-buzz 30)

(defn fizz-buzz-range
  [start end]

  (defn fizz-buzz
    [x]
    (cond
      (= (mod x 15) 0) "FizzBuzz"
      (= (mod x 5) 0) "Buz"
      (= (mod x 3) 0) "Fizz"
      :else (str x)
      )
    )

  (defn reducer
    [acc curr]
    (conj acc (fizz-buzz curr))
    )

  (def arr (range start (+ end 1)))

  (reduce reducer [] arr)
  )

(def expected ["1" "2" "Fizz" "4" "Buz" "Fizz" "7" "8" "Fizz" "Buz" "11" "Fizz" "13" "14" "FizzBuzz"])

(assert
 (= (fizz-buzz-range 1 15) expected)
 (str "Result is not equal. Something wrong: " expected)
 )
