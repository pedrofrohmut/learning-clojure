#!/usr/bin/env -S clojure -M

;; cli-todos.clj
;; Pedro Frohmut 2026 Copyrights
;; A cli tool to save, check and remove todos

(ns cli-todos
  (:require [clojure.string :as str])
  (:require [clojure.java.io :as io]))

(defn file-exists? [todos-file] (.exists (io/file todos-file)))

(defn new-todo-file
  "Creates a todo file in the current directory if none found"
  [todos-file]

  (spit todos-file "")
  )

(defn list-todos
  "List the todos in the file"
  [todos-file]

  (with-open [rdr (io/reader todos-file)]
    (let [number-the-line (fn [index line] (str (inc index) ". " line))
          lines (line-seq rdr)
          numbered-lines (mapv number-the-line (range) lines)]

      (if (empty? lines)
        (do (println "No todos in the file.")
            (println "You can add todos with: cli-todos save 'Buy milk'"))

        (doseq [line numbered-lines]
          (println line)))
  )))

(defn save-todo
  "Append a new todo to the end of file"
  [args todos-file]

  (if (empty? (second args))
    (println "Cannot add empty todos")

    (do (spit todos-file (str (second args) "\n") :append true)
        (list-todos todos-file))
  ))

(defn remove-todo
  "Remove a todos passing the number of the line"
  [args todos-file]

  (let [line-to-remove (parse-long (second args))
        invalid-number (= nil line-to-remove)]

    (if invalid-number
      (println "Error: invalid value for line number. Line number should be an integer positive number.")

      (with-open [rdr (io/reader todos-file)]
        (let [file-lines (line-seq rdr)
              empty-file (zero? (count file-lines))
              too-high (> line-to-remove (count file-lines))
              too-low (< line-to-remove 1)]

          (cond
            empty-file
            (println "Error: the file is empty.")

            too-high
            (do (println "Error: line number is too high. File does not have this line.")
                (list-todos todos-file))

            too-low
            (do (println "Error: The line number should be an integer value bigger than zero.")
                (list-todos todos-file))

            :else
            (do (let [index-it (fn [i line] (vector (str (inc i)) line))
                      indexed-lines (map index-it (range) file-lines)
                      reducer (fn [acc, curr]
                                (let [index (str (first curr))
                                      updated-acc (conj acc (str (second curr) "\n"))]
                                  (if (= index (str line-to-remove))
                                    acc
                                    updated-acc)))
                      new-lines (reduce reducer [] indexed-lines)
                      content (str/join "" new-lines)]

                (spit todos-file content))
              (list-todos todos-file))
  ))))))

(defn print-usage [] (println "Usage: cli-todos [new|save|remove|list]"))

(defn -main
  "Entry point for the cli todos tool"
  [& args]

  (let [todos-file "todos.txt"
        option (first args)
        todo-exists (file-exists? todos-file)]

    ;; Ask for file creation if todos file not found
    (if (and (not todo-exists) (not= option "new"))
      (do (println (str "File not found with name '" todos-file "' in the current folder"))
          (println "Usage: 'cli-todos new' to create the file if wanted"))

      (case (first args)
        "new"    (new-todo-file todos-file)
        "save"   (save-todo args todos-file)
        "remove" (remove-todo args todos-file)
        "list"   (list-todos todos-file)
        (print-usage)
  ))))

;; You wont get args without this
(apply -main *command-line-args*)
