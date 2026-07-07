(ns tutorial.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn data-types []
  (def num1 10) ;; Creates a long
  (def num2 1.23) ;; Creates a double
  (type false) ;; Check what is the type

  ;; Positive or negative, even or odd ...
  (pos? 15)
  (neg? -4)
  (even? 3)
  (odd? 3)
  (number? "Hello")
  (string? 123)
  ;; ...

  (def aLong 14)
  (nil? aLong) ;; Check if the value is nil
  )

(defn  format-stuff []
  (format "This is string %s" "FOO")
  (format "5 spaces %5d" 123)
  (format "Leading zeros %08d" 1234)
  (format "%-8d left justified" 15)
  (format "3 decimals %.3f" 1.234567))

(defn check-strings []
  (let [str1 "This is my 2nd string"]
    (str/blank? str1)
    (str/includes? str1 "my")
    (str/includes? str1 "foo")
    (str/index-of str1 "my")
    (str/split str1 #" ") ;; Use the # symbol to tell that it is a regex pattern
    (str/split str1 #"\d")
    (str/join ", " ["Foo" "Bar" "Baz"])
    (str/replace "I am 42 years old." #"42" "43")
    (str/trim "         foo  ")
    (str/upper-case str1)
    (str/lower-case str1))
  )

(defn check-lists []
  (let [my-list (list "Dog" 1 3.4 true)]
    (first my-list)
    (last my-list)
    (rest my-list)
    (nth my-list 2)
    )

  ;; Macro to define a list
  (list* 1 2 [3 4])

  (cons "first" (list "second" "third"))
  )

;; A data structure with unique values
(defn check-sets []
  (set '(1 2 2)) ;; make a set
  (get (set '("a" "b" "c" "d")) "a")
  (get (set '("a" "b" "c" "d")) "foo")
  (conj (set '(2 3)) 1) ;; Prepend to set
  (contains? (set '(1 2 3 4)) 5)
  (contains? (set '(1 2 3 4)) 2)
  )

(defn check-vectors []
  (let [numbers (vector 1 2 3 4 5 6)
        letters (vector "a" "b" "c" "d" "e")
        ]
    (get letters 2)
    (get numbers 1)
    (conj numbers 666) ;; append to end
    (pop numbers) ;; remove last item
    (subvec letters 1 3) ;; get a slice of the vector start to exclusive end
    )
  )

(defn check-maps []

  ;; key/value pairs
  (def my-map (hash-map "name" "John Doe" "age" 69))
  (println my-map)

  ;; key/value pairs sorted by keys
  (def my-sorted (sorted-map 3 42 2 "Doe" 1 "John"))
  (println my-sorted)

  (get my-map "name")
  (get my-map "foo")
  (find my-map "name")
  (find my-map "foo")
  (contains? my-map "age")
  (contains? my-map "foo")
  (keys my-map)
  (vals my-map)

  (merge-with + my-map (hash-map "address" "123 Main st")) ;; merge 2 maps together
  )

(defn atom-ex [x]

  (def atomEx (atom x))

  (add-watch atomEx :watcher
       (fn [key atom old-state new-state]
         (println "atomEx changed from " old-state " to " new-state)
         )
       )

  (println "1st x" @atomEx)
  (reset! atomEx 10)
  (println "2nd x" @atomEx)
  (swap! atomEx inc)
  (println "Incremented x" @atomEx)
  )

(defn agent-ex [x]
  (def tickets-sold (agent x))

  (println "Sold before: " @tickets-sold)
  (send tickets-sold + 15)

  ;; Dealing with agents is async operation. So if you dont wait here it will call
  ;; the second println before the tickets have been updated
  (await-for 100 tickets-sold)
  (println "Sold after: " @tickets-sold)

  (send tickets-sold + 10)
  (await-for 100 tickets-sold)
  (println "Sold after2: " @tickets-sold)

  (shutdown-agents)
  )

(defn check-math-stuff []
  (+ 1 2 3)
  (- 5 3 2)
  (* 2 5)
  (/ 10 3)
  (mod 12 5) ;; remainder

  (inc 5)
  (dec 5)

  (Math/abs -10)
  (Math/cbrt 8)
  (Math/sqrt 4)
  (Math/exp 1)
  (Math/hypot 2 2)
  (Math/log 2.71828)
  (Math/log10 100)
  (Math/ceil 2.5)
  (Math/floor 2.5)
  (Math/max 1 5)
  (Math/min 1 5)
  (Math/pow 2 2)

  (Math/PI)

  (rand-int 20) ;; Gets a random int up to 20

  (reduce + [1 2 3 4 5])
  )

(defn say-hello
  "Receives a name a returns a greeting message with that name"
  [name]

  (format "Hello, %s!" name)
  )

(defn get-sum2
  "Sum two values"
  [x y]

  (+ x y)
  )

(defn get-sum3
  "Sum 3 values"
  [x y z]

  (+ x y z)
  )

(defn sum-all
  "Sum variable number or arguments"
  [& xs]

  (reduce + xs)
  )

(defn hello-you
  [name]

  (str "Hello " name)
  )

(defn hello-all
  []

  (map hello-you (vector "John" "Ana" "Bob" "Jane"))
  )

(defn print-hellos
  ""
  []

  (let [hellos (hello-all)
        ]
    (doseq [hello hellos]
      (println hello)
      )
    )
  )

(defn hellos2
  ""
  []

  (let [names (vector  "John" "Ana" "Bob" "Jane")
        hellos (map (fn [name] (str "Hello, " name "!")) names)
        ]

    (doseq [hello hellos]
      (println hello)
      )
    )
  )

(defn hello-all3
  ""
  [& names] ;; variadic number of arguments

  (map (fn [name] (str "Hello " name)) names)
  )

(defn print-hellos3 [] (hello-all2 "Doug" "Mary" "Paul" "Julian"))

(defn check-conditions
  []

  (= 4 5)
  (not= 4 5)
  (and true false)
  (and (= "foo" "foo") (= "bar" "bar"))
  (or (= "foo" "foo") (= "bar" "bar"))
  (not (= "foo" "bar"))
  )

(defn can-vote?
  [age]

  (if (>= age 18)
    (println "Can vote.")
    (println "Cannot vote yet.")
    )
  )

(defn can-do-more
  [age]

  (if (>= age 18)
    (do
      (println "You can vote.")
      (println "You can drive.")
      )
    (if (>= age 16)
      (do
        (println "You can drive.")
        (println "You can't vote.")
        )
      (do
        (println "You can't vote.")
        (println "You can't drive.")
        )
      )
    )
  )

(can-do-more 15)
(can-do-more 17)
(can-do-more 19)

(defn check-when
  [true-or-false]

  ;; using when you only execute in case of true and you dont need the do block
  ;; to call more than 1 function
  (when true-or-false
    (println "1st thing")
    (println "2nd thing")
    )
  )

(check-when true)
(check-when false)

(defn what-grade?
  [age]

  (cond
    (< age 0) "Error: age cannot be negative."
    (< age 5) "Preschool"
    (< age 6) "Kindergarten"
    (< age 19) (format "You are %d grade" (- age 5))
    :else "College"
    )
  )

(what-grade? 3)
(what-grade? 5)
(what-grade? 7)
(what-grade? 15)
(what-grade? 19)

(defn what-grade2
  [age]

  (cond
    (< age 5)
        "Preschool"
    (= age 5)
        "Kindergarten"
    (and (> age 5) (<= age 18))
        (format "Go to grade %d" (- age 5))
    :else
        "Go to college"
    )
  )

(what-grade2 4)
(what-grade2 5)
(what-grade2 6)
(what-grade2 18)
(what-grade2 21)

(defn can-do-at?
  [age]

  (def cans [])

  (when (>= age 16)
    (def cans (conj cans "Can drive"))
    )

  (when (>= age 18)
    (def cans (conj cans "Can vote"))
    )

  (when (>= age 21)
    (def cans (conj cans "Can drink alcohol"))
    )

  (when (>= age 65)
    (def cans (conj cans "Can retire"))
    )

  cans
  )

(defn one-to-x
  [x]

  (def i (atom 1))

  (while (<= @i x)
    (print @i " ")
    (swap! i inc)
    )

  (println)
  )

(one-to-x 1)
(one-to-x 5)
(one-to-x 15)

(defn dbl-to-x
  [x]

  (dotimes [i x]
    (print (* i 2) " ")
    )
  (println)
  )

(dbl-to-x 4)
(dbl-to-x 8)
(dbl-to-x 16)
(dbl-to-x 32)

(defn triple-from-x-to-y
  "prints the triple of n from start to finish incrementing n by 1 each time"
  [start end]

  (loop [i start]
    (when (<= i end)
      (print (* i 3) " ")
      (recur (+ i 1)) ;; Increment i by 1
      )
    )
  (println)
  )

(triple-from-x-to-y 3 18)
(triple-from-x-to-y 5 10)
(triple-from-x-to-y 1 5)

(defn print-list
  "Prints a list with values separade by spaces and a new line character at the end"
  [& nums]

  (doseq [n nums]
    (print n " ")
    )
  (println)
  )

(print-list 1 2 3 4 5 6 7)
(print-list "a" "b" "c" "d" "e")
(print-list 'foo 'bar 'baz 'bux)

(use 'clojure.java.io)

(defn write-to-file
  "Creates or overwrite a file by filename with text as string"
  [filename text]

  (with-open [wtr (writer filename)]
    (.write wtr text)
    )
  )

;; Creates a file in the project root <project_root>/foo.txt
;; with content "foo bar baz"
(write-to-file "foo.txt" "foo bar baz\n")

(defn read-from-file
  ""
  [filename]

  (try
    (println (slurp filename))

    (catch Exception e
      (println "Error: " (.getMessage e))
      )
    )
  )

(read-from-file "foo.txt")
(read-from-file "bar.txt")

(defn append-to-file
  "Append text to the a file by filename and text as string"
  [filename text]

  (with-open [wtr (writer filename :append true)]
    (.write wtr text)
    )
  )

(append-to-file "foo.txt" "boing\n")
(append-to-file "foo.txt" "buing\n")
(append-to-file "foo.txt" "bang\n")

(defn read-line-from-file
  "Read line by line from file"
  [filename]

  (with-open [rdr (reader filename)]
    (doseq [line (line-seq rdr)]
      (println line)
     )
    )
  )

(read-line-from-file "foo.txt")

(defn destruct
  "destruct a list in first second and the rest of the list then print it out"
  []

  (let [vectVals [1 2 3 4 5]
        [one two & the-rest] vectVals
        ]
    (println one two the-rest)
    )
  )

(destruct)

(defn struct-map-ex
  ""
  []

  ;; Defines a struct Customer with field Name and Phone
  (defstruct Customer :Name :Phone)

  (let [
        ;; struct - Inits a struct following the order of the fields
        cust1 (struct Customer "Doug" 12345678)
        ;; struct-map - Inits a struct providing the keys where the order does not matter
        cust2 (struct-map Customer :Phone 12341234 :Name "Sally")
        ]
    (println cust1)
    (println cust2)
    (println (:Name cust2))
    (println (cust1 :Name))
    )
  )

(struct-map-ex)

(defn print-squares
  ""
  []

  ;; Defines a lambda function and assigns it to my-sqr
  (def my-sqr (fn [x] (* x x)))

  (let [
        ;; Uses the lambda function to get the squares of range 1 to 15
        sqrs (map my-sqr (range 1 15))
        ]
    (doseq [sqr sqrs]
      (print sqr " ") ;; Print sqrs in the same line
      )
    (println)
    )
  )

(print-squares)

(defn print-squares2
  ""
  []

  ;; You can define the function right in the map call. It does not need to have
  ;; a name and to be defined before hand.
  (let [xs (map (fn [x] (* x x)) (range 1 15))
        ;; This is a compact anonymus function that would be the same of (fn [x] (* x 3))
        ys (map #(* % 3) (range 1 15))]

    (print "XS => ")
    (doseq [x xs]
      (print x " ")
      )
    (println)

    (print "YS => ")
    (doseq [y ys]
      (print y " ")
      )
    (println)

    )
  )

(print-squares2)

;; Clojures - The is a currying function a function that returns a function with values presetted
(defn custom-multiplier
  ""
  [mult-by]

  ;; The function to be returned with the argument attached to it
  #(* % mult-by)
  )

(def mult-2 (custom-multiplier 2))
(def mult-3 (custom-multiplier 3))
(def mult-4 (custom-multiplier 4))

(mult-2 25)
(mult-3 25)
(mult-4 25)

(defn check-list-utils
  []
  (let [alist '(1 2 3 4 5 6)]
    (println "Take 2: " (take 2 alist))
    (println "Drop 1: " (drop 1 alist))
    (println "Take-while x < 4: " (take-while #(< % 4) alist))
    (println "Drop-while x < 4: " (drop-while #(< % 4) alist))
    (println "Filter odd: " (filter odd? alist))
    )
  )

(check-list-utils)

(defmacro discount
  ""
  ([cond disc1 disc2]
   (list `if cond disc1 disc2)
   )
  )

(defn check-discount
  [age]

  (discount (< age 65) "10% Off" "25% Off")
  )

(check-discount 25)
(check-discount 50)
(check-discount 75)

(defmacro reg-math
  "Use it to make a regular math calc like: (2 + 2)"
  [calc]
  (list (second calc) (first calc) (nth calc 2))
  )

(reg-math (2 + 5))
(reg-math (3 * 5))
(reg-math (25 / 5))

(defmacro do-more
  "macro for if cond execute the body"
  [cond & body]

  (list `if cond (cons 'do body))
  )

(do-more (< 1 2)
  (println "one")
  (println "two")
  (println "three")
  )

(do-more (< 3 2)
  (println "four")
  (println "five")
  (println "six")
  )

(defmacro do-more-2
  "Same as the other macro but with ` outside and escaping code inside with ~"
  [cond & body]

  ;; the ` here means to treat the sentence as data and not evaluate it
  ;; the ~ here is to escape the data mode and evaluate some parts. escape some parts
  `(if ~cond (do ~@body))
  )

(do-more-2 (< 1 2)
  (println "one")
  (println "two")
  (println "three")
  )

(do-more-2 (< 3 2)
  (println "four")
  (println "five")
  (println "six")
  )

(defn -main
  "Main function nothing to do here."
  [& args]
  )
