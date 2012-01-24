(ns tuesdaylunch.episode1
  (:use [clojure.string :only [join]])
  (:import [java.util ArrayList]))
 
(defn -main [& args]
  (println (str "hello worlds: " (join ", " args))))

;from REPL
(use 'tuesdaylunch.episode1)

(-main "Frogstar World A" "Frogstar B" "Frogstar World C")

(if true :truthy :falsey)
(if [] :truthy :falsey)
(if nil :truthy :falsey)
(if false :truthy :falsey)


;set
(def a-set #{:bright :copper :kettles})
;(def not-a-set #{:bright :copper :kettles :bright})

;map
(def a-map {:species "monkey" :emotion "angry"})
(def another-map {"A" 23 "B" 83})

;vector
(def a-vector [1 2 3 4 5])
(def another-vector ["A" "B" "C"])

;list
(def a-list '(42 43 44))
(def another-list (map str [1 2 3 4 5]))

(defn interoperate-with-java [var-name]
  (do
    (println (System/getenv var-name))
    (let [list (ArrayList.)]
      (.addAll list [1 2 3])
      (println (join ", " list)))))