(ns FunctionalProgrammingLab1.laba1)

(defn dfs [current finish ways visited]
  (do
    (if-not (contains? visited current)
      (if (= current finish)
        (do
          (lazy-seq (conj visited current))
          )
        (for [possible (ways current)]
          (do
            (lazy-seq (dfs possible finish ways (conj visited current)))
            )
          )
        )
      )
    )
  )

(let [res (dfs 0 4 [[1 2] [0 2] [0 1 3] [2 4] [3]] [])]
  (println "result")
  (println res)
  )