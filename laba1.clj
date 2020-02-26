(ns FunctionalProgrammingLab1.laba1)

(defn bfs [current finish ways visited]
  (if-not (contains? visited current)
    (if (= current finish)
      (lazy-seq (conj visited current))
      (for [possible (ways current)]
        (lazy-seq (bfs possible finish ways (conj visited current)))
        )
      )
    )
  )

(println (bfs 0 4 [[1 2] [0 2] [0 1 3] [2 4] [3]] []))