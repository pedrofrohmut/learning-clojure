;; Namespace - ns
(ns tutorial.core
    (:gen-class))

(defn -main
    "I don't do a whole lot... yet"
    [& args]
    (def randVar 10)
    (println "RandVar:     " randVar)
    (def aDouble 1.333)
    (println "ADouble:     " aDouble)
    (def aLong 15)
    (println "Is nil?      " aLong (nil? aLong))
    (println "Is positive? " -666 (pos? -666))
    (println "Is negative? " -666 (neg? -666))
    (println "Is even?     " 42 (even? 42))
    (println "Is odd?      " 42 (odd? 42))
    (println "Is number?   " 42 (number? 42))
    (println "Is interger? " 42 (integer? 42))
    (println "Is float?    " 42 (float? 42))
    (println "Is zero?     " 42 (zero? 42))
    )

(-main)
