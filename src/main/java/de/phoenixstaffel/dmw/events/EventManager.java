package de.phoenixstaffel.dmw.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.phoenixstaffel.dmw.utils.Tuple;

public class EventManager {
    private Map<Class<? extends Event>, List<Tuple<Object, Method>>> handlers = new HashMap<>();
    
    @SuppressWarnings("unchecked")
    public void registerEvents(Object obj) {
        for (Method method : obj.getClass().getMethods()) {
            if (method.getDeclaredAnnotation(EventHandlingMethod.class) == null)
                continue;
            
            Class<?> parameterClass = method.getParameters()[0].getType();
            
            if (method.getParameterCount() != 1 || !Event.class.isAssignableFrom(parameterClass)) {
                System.out.println("method x is declared as event handling, but it's parameter declaration is invalid");
                continue;
            }
            
            if (!handlers.containsKey(parameterClass))
                handlers.put((Class<? extends Event>) parameterClass, new ArrayList<Tuple<Object, Method>>());
            
            handlers.get(parameterClass).add(new Tuple<Object, Method>(obj, method));
        }
    }
    
    public void callEvent(Event event) {
        if (handlers.containsKey(event.getClass()))
            for (Tuple<Object, Method> a : handlers.get(event.getClass())) {
                try {
                    a.getSecondValue().setAccessible(true);
                    a.getSecondValue().invoke(a.getFirstValue(), event);
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
    }
}
