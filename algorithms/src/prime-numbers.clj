;; prime-numbers.clj
;; Pedro Frohmut 2026 Copyrights
;; List the prime numbers up to a limit
;; Primes 1 to 100
;; 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97

;; Loop version
(defn old-is-prime?
  [n]

  (if (< n 2)
    false

    (loop [i 2]
      (assert (<= i n) (str "Unreacheable: i is " i))
      (cond
        (= i n) true
        (zero? (mod n i)) false
        :else (recur (inc i)))
      )
    )
  )

;; Recursion version
(defn is-prime?
  ([n]
   (is-prime? n 2)
   )
  ([n i]
   (cond
     (< n 2) false
     (= n i) true
     (= (mod n i) 0) false
     :else (is-prime? n (inc i))
     )
   )
  )

(assert (is-prime? 2))
(assert (not (is-prime? 4)))
(assert (is-prime? 3))
(assert (is-prime? 5))
(assert (not (is-prime? 6)))
(assert (is-prime? 7))
(assert (not (is-prime? 8)))
(assert (not (is-prime? 9)))
(assert (is-prime? 11))
(assert (is-prime? 13))
(assert (not (is-prime? 10)))
(assert (not (is-prime? 20)))
(assert (not (is-prime? 30)))
(assert (not (is-prime? 40)))

(defn list-primes
  [limit]

  (let [arr (range 1 (+ limit 1))]
    (filter is-prime? arr)
  ))

(def primes-to-100 [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97])
(assert (= (list-primes 100) primes-to-100))
