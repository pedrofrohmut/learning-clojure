#!/usr/bin/env -S clj -M

;; guess-the-number-game3.clj
;; Pedro Frohmut 2026 Copyrights
;; Version 3
;; Guess the number game with cond and loop

(defn calculate-score
  "Calculate the game based on the number of guesses"
  [guesses]

  (let [lost-points (* guesses 10)]
    (if (> lost-points 100)
      0
      (- 100 lost-points)

      ))) ;; score

(defn main
  "Entry point of the app"
  []

  (let [the-number (+ 1 (rand-int 100))]

    ;; Comment it if you want it to be a secret
    (println (str "The number is: " the-number))

    (loop [guesses 0]
      (println "Insert a number between 1 and 100")
      (let [
            input (parse-long (read-line))
            parser-error? (fn [n] (nil? n))
            out-of-range-error? (fn [n] (or (< n 1) (> n 100)))
            too-low? (fn [n] (< n the-number))
            too-high? (fn [n] (> n the-number))
            ]

        (cond

          (parser-error? input)
          (do (println "Parser error. Input must be a number between 1 and 100.")
              (recur guesses))

          (out-of-range-error? input)
          (do (println "Out of range value. Value should be between 1 and 100.")
              (recur guesses))

          (too-low? input)
          (do (println "Too low. Try higher.")
              (recur (inc guesses)))

          (too-high? input)
          (do (println "Too high. Try lower.")
              (recur (inc guesses)))

          :else
          (do (println "You guessed!")
              (println (str "The number is " the-number ". Congratulations!!!"))
              (println (str "You used " (inc guesses) " to find the number."))
              (println (str "Your score was " (calculate-score (inc guesses)) ".")))

          ))))) ;; main

(main)
