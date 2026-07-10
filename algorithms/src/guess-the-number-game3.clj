;; guess-the-number-game3.clj
;; Pedro Frohmut 2026 Copyrights
;; Version 3
;; Guess the number game with cond and loop

(defn main
  "Entry point of the app"
  []

  (let [the-number (+ 1 (rand-int 100))]

    ;; Comment it if you want it to be a secret
    (println (str "The number is: " the-number))

    (loop [_ true]
      (println "Insert a number between 1 and 100")
      (let [input (parse-long (read-line))]
        (cond

          (not input)
          (do (println "Parser error. Input must be a number between 1 and 100.")
              (recur true))

          (or (< input 1) (> input 100))
          (do (println "Out of range value. Value should be between 1 and 100.")
              (recur true))

          (< input the-number)
          (do (println "Too low. Try higher.")
              (recur true))

          (> input the-number)
          (do (println "Too high. Try lower.")
              (recur true))

          :else
          (do (println "You guessed!")
              (println (str "The number is " the-number ". Congratulations!!!")))

          ))))) ;; main

(main)
