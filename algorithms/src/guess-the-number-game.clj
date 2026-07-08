;; guess-the-number-game.clj
;; Pedro Frohmut 2026 Copyrights

(defn game-loop
  "Runs a game loop end on success or loops again otherwise"
  [right-number]

  (println "Enter a number between 1 and 100")
  (def user-input (parse-long (read-line)))
  (def parsing-error (not user-input)) ;; parse-long returns nil in case of parsing error
  (def out-of-bounds-error (or (< user-input 1) (> user-input 100)))
  (def user-guessed (= user-input right-number))

  (if (parsing-error)
    (do
      (println "Not a valid integer. The input could not be parsed.")
      (game-loop right-number)
      )

    (if (out-of-bounds-error)
      (do
        (println "[Error] User input must be between 1 and 100")
        (game-loop right-number)
        )

      (if (user-guessed)
        (println "[Success] You guessed the number.")

        (do
          (if (< user-input right-number)
            (println "Not yet. Try higher.")
            (println "Not yet. Try lower.")
            )
          (game-loop right-number)
          )
        )
      )
    )
  )

(defn game-round
  "Runs a game round"
  []

  (def right-number (rand-int 100))
  ;; (println (str "Right number: " right-number))

  (game-loop right-number)
  )

(defn check-answer
  []

  (println "Play again? [yes] / [No]")
  (def user-input (clojure.string/upper-case (read-line)))

  (if (or (= user-input "") (= user-input "NO") (= user-input "N"))
    false
    (if (or (= user-input "YES") (= user-input "Y"))
      true
      (do
        (println "Please answer [yes] or [no]")
        (check-answer)
        )
      )
    )
  )

(defn main
  []

  (game-round)

  (when (check-answer)
    (main)
    )
  )

(main)
