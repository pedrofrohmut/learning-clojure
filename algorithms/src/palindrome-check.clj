;; palindrome-check.clj
;; Pedro Frohmut 2026 Copyrights

(defn is-palindrome
  [source]

  (def reversed (reduce (fn [acc curr] (str curr acc)) "" source))
  (= reversed source)
  )

(defn is-palindrome-test
  "Test for is-palindrome function that receives the string source and the expected
  result of calling is-palindrome on it."
  [source expected]

  (def result (is-palindrome source))
  (assert
   (= expected result)
   (format "is-palindrome for \"%s\" should be %b but got %b instead" source expected result)
   )
  )

(is-palindrome-test "foobar" false)
(is-palindrome-test "baxub" false)
(is-palindrome-test "aba" true)
(is-palindrome-test "abba" true)
(is-palindrome-test "ababa" true)
