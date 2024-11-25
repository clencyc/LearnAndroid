## State in compose
state is any value that can change overtime
        eg: recent messages saved in a chat application

to change the state, you use events (inputs outside or inside or outside the app)

Composition and 
Recomposition: re-running composables to update the composition when data changes
Compose's state tracking system schedules recompositions for any composables that read a particular state


Stateful composable - not reusable hard to test
Stateless composable - reusable, easy to test

State hoisting - moving state to a composable's caller to make a composable stateless
                - check on UDF

