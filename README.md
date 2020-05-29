# Ful-Frame


## Quick outline


This is an experimental repo for now - I don't know if it will go anywhere. The idea is simple enough though. Fulcro is based around a normalized database, and through that choice simplifies the story around mutations greatly. Re-frame is based on a derived data tree, which lends itself to easily defined derived ui without worrying about caching. In fulcro this feature is not required, but it can be very useful. In projects with fulcro I have designed systems that work like a poor mans version of Re-frame. In general, I like the fulcro system better, but it also comes with a ton of additional baggage, since it is designed as a one stop shop for full stack clojure applications. I am experiemnting with the possibility that a stripped version of fulcro + a custom re-frame implemntation could lend itself to a much nicer ui story. 
