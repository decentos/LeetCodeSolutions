package graph.topologicalsort;

import java.util.*;

public class M2115FindAllPossibleRecipes {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();

        Set<String> suppliesSet = new HashSet<>();
        Collections.addAll(suppliesSet, supplies);

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, 0);

            for (String ingredient : ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    inDegree.merge(recipe, 1, Integer::sum);
                    adj.computeIfAbsent(ingredient, val -> new ArrayList<>()).add(recipe);
                }
            }
        }

        List<String> possibleRecipes = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();

        inDegree.forEach((recipe, ingredient) -> {
            if (ingredient == 0) {
                queue.offer(recipe);
            }
        });

        while (!queue.isEmpty()) {
            String recipe = queue.poll();
            possibleRecipes.add(recipe);

            if (adj.containsKey(recipe)) {
                List<String> dependents = adj.get(recipe);
                for (String dependent : dependents) {
                    int count = inDegree.merge(dependent, -1, Integer::sum);

                    if (count == 0) {
                        queue.offer(dependent);
                    }
                }
            }
        }
        return possibleRecipes;
    }
}
