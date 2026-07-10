;; guess-the-number-game2.clj
;; Pedro Frohmut 2026 Copyrights
;; Version 2
;; Guess game with loop and if expressions

(defn main
  "Entry point with nested if expressions"
  []

  (let [the-number (+ 1 (rand-int 100))]

    ;; Comment this out if you want it to be a secret
    (println (str "The number is: " the-number))

    (loop [_ true]

      (println "Insert a number between 1 and 100")
      (let [input (parse-long (read-line))
            parser-error (not input)] ;; parse-int returns nil in case of invalid argument

        (if parser-error
          (do (println "Parser error. Input must be a number between 1 and 100.")
              (recur true))

          (let [out-of-range-error (or (< input 1) (> input 100))
                too-low (< input the-number)
                too-high (> input the-number)]

            (if out-of-range-error
              (do (println "Out of range value. Value should be between 1 and 100.")
                  (recur true))

              (if too-low
                (do (println "Too low. Try higher.")
                    (recur true))

                (if too-high
                  (do (println "Too high. Try lower.")
                      (recur true))

                  (do (println "You guessed!")
                      (println (str "The number is " the-number ". Congratulations!!!")))
                  )))

            )))))) ;; main

(main)
