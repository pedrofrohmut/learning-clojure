;; Pedro Frohmut 2026 Copyrights

(ns algorithms.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn list-to-string-aux
  [alist acc]

  (if (empty? alist)
    acc
    (let [head (first alist)
          tail (rest alist)
          new-acc (str acc head)
          ]
      (list-to-string-aux tail new-acc)
      )
    )
  )

(defn list-to-string
  [alist]

  (list-to-string-aux alist "")
  )

(defn rev-aux
  [src acc]

  (if (empty? src)
    (list-to-string acc)
    (let [head-src (first src)
          new-src  (rest src)
          new-acc  (cons head-src acc)
          ]
      (rev-aux new-src new-acc)
      )
    )
  )

(defn reverse-string
  [src]

  (rev-aux src "")
  )

(assert
 (= "oof" (reverse-string "foo"))
 "\"foo\" when reversed should be equal to \"oof\""
 )

(assert
 (= "raboof" (reverse-string "foobar"))
 "\"foobar\" when reversed should be equal to \"raboof\""
 )

;; Multi-arity function call: can be called with both [src] or with [src acc]
(defn rev-str
  "Reverses a string"
  ([src]

   (rev-str src "")
   )

  ([src acc]

   (if (empty? src)
     acc
     (let [tail (rest src)
           head (first src)
           new-acc (str head acc)]
       (rev-str tail new-acc)
       )
     )
   )
  )

(assert
 (= "raboof" (rev-str "foobar" ""))
 "\"foobar\" when reversed should be equal to \"raboof\""
 )

(assert
 (= "raboof" (rev-str "foobar"))
 "\"foobar\" when reversed should be equal to \"raboof\""
 )

(defn rev-str2
  "Reverse a string"
  [src]

  (reduce (fn [acc curr] (str curr acc)) "" src)
  )

(assert
 (= "raboof" (rev-str2 "foobar"))
 "\"foobar\" when reversed should be equal to \"raboof\""
 )

(assert
 (= "raboof" (rev-str2 "foobar"))
 "\"foobar\" when reversed should be equal to \"raboof\""
 )
