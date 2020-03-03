
(def graph [{:value 15 :name "Kris" :nei [1 4]} {:value 220 :name "Andrew" :nei [0 2]}
            {:value 320 :name "Alex" :nei [1 3]} {:value 44 :name "Ira" :nei [2 5]}
            {:value 50 :name "Kirill" :nei [0 5]} {:value 630 :name "Ura" :nei [3 4]}])

(defn search [graph start key_v value]
  (loop [curr nil queue (apply list (:nei (get graph start))) visited #{}]
    (if (empty? queue)
      nil
      (if (and (not (nil? curr)) (not (contains? curr visited)))
        (if (= (key_v curr) value)
          curr
          (recur (get graph (first queue))
                 (apply list (distinct (into (pop queue) (:nei curr))))
                 (cons visited curr))
          )
        (recur (get graph (first queue)) (pop queue) visited)
        )
      )
    )
  )

(search graph 0 :name "Alex")
(search graph 0 :value 630)