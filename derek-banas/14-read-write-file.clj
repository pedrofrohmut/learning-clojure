;; Namespace - ns
(ns tutorial.core
  (:gen-class))

(use 'clojure.java.io)

(defn write-to-file [file text]
  (with-open [wrtr (writer file)]
    (.write wrtr text)))

(defn read-from-file [file]
  (try
    (println slurp file)
  (catch Exception e
    (println "Error: " (.getMessage e)))))

(defn append-to-file [file text]
  (with-open [wrtr (writer file :append true)]
    (.write wrtr text)))

(defn read-line-from-file [file]
  (with-open [rdr (reader file)]
    (doseq  [line (line-seq rdr)]
      (println line))))

;; defn - define function
;; & args - list of args - & means variable parameter
(defn main [& args]
  (write-to-file "test.txt" "This is a sentence\n")
  (read-from-file "test.txt")
  (append-to-file "test.txt" "This is another sentence\n")
  (read-line-from-file "test.txt")
  ) ;; main

(main)
