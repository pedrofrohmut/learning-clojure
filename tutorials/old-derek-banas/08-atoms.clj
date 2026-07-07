;; Namespace - ns
(ns tutorial.core
    (:gen-class))

(defn atom-ex [x]
    (def atomEx (atom x))

    (add-watch atomEx :watcher
        ;; Callback called every time the atom changes state
        (fn [key atom old-state new-state]
            (println "atomEx changed from" old-state "to" new-state)))

    (println "1st x" @atomEx)

    ;; Set value of the atom without checking old-state
    (reset! atomEx 10)
    (println "2nd x" @atomEx)

    ;; Change value applying a function to current value of the atom
    (swap! atomEx inc)
    (println "Increment x" @atomEx)
    ) ;; atom-ex


;; defn - define function
(defn main []
    (atom-ex 5)
    ) ;; main

(main)
