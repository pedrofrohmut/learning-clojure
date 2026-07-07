;; Namespace - ns
(ns tutorial.core
    (:gen-class))

(defn agent-ex []
    (def tickets-sold (agent 0))
    (def time-to-await 1)

    (send tickets-sold + 15)
    (await-for time-to-await tickets-sold) ;; Like sleep function
    (println "Tickets" @tickets-sold)

    (send tickets-sold + 10)
    (await-for time-to-await tickets-sold)  ;; Like sleep function
    (println "Tickets" @tickets-sold)

    (shutdown-agents)
    ) ;; agents

;; defn - define function
(defn main []
    (agent-ex)
    ) ;; main

(main)
