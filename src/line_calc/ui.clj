;;
;; UI Modules
;;

(ns line-calc.ui
  (:import (javax.swing JFrame JPanel JLabel JButton)
           (java.awt Dimension)))

; create a calculator UI
(defn create-ui []
  (let [frame (JFrame. "line-calc")
        panel (JPanel.)
        label (JLabel.)]
    
    (doto label
      (.setPreferredSize (Dimension. 500 100))
      (.setVisible true))
    
    (doto panel
      (.setPreferredSize (Dimension. 700 150))
      (.setVisible true))
    
    (doto frame
      (.add panel)
      (.add label)
      (.pack)
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.setResizable false)
      (.setVisible true))))
