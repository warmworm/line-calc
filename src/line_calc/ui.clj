;;
;; UI Modules
;;

(ns line-calc.ui
  (:import (javax.swing Box BoxLayout JFrame JPanel JOptionPane
                        JTextArea JTextField JLabel JButton)
           (java.awt BorderLayout GridLayout FlowLayout
                     Container Component Dimension)
           (java.awt.event ActionListener)))

(defn alert
  ([msg] (alert nil msg))
  ([frame msg]
   (JOptionPane/showMessageDialog frame msg)))

; create a calculator UI
(defn create-ui [title]
  (let [frame (JFrame. title)
        log-panel (JPanel.)
        panel (JPanel.)
        log (JTextArea. 5 20)
        label (JLabel. "Expression:")
        exp (JTextField.)
        button (JButton. "Eval")]

    ;(doto label
    ;  (.setPreferredSize (Dimension. 150 50)))

    (doto log
      (.setSize (Dimension. 300 300)))
    
    (doto exp
      (.setSize (Dimension. 500 50))
      (.setColumns 50)
      (.setText "Input Expression"))

    (doto button
      (.setSize (Dimension. 150 50))
      (.addActionListener
       (proxy [ActionListener] []
         (actionPerformed [_]
           (.append log (str (.getText exp) \newline))))))

    (doto log-panel
      (.setLayout (BorderLayout.))
      (.add log BorderLayout/CENTER))
    
    (doto panel
      (.setLayout (BorderLayout.))
      (.add log-panel BorderLayout/NORTH)
      (.add label BorderLayout/WEST)
      (.add exp BorderLayout/CENTER)
      (.add button BorderLayout/EAST))
    
    (doto frame
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.setContentPane panel)
      (.pack)
      (.setResizable false)
      (.setVisible true))))
