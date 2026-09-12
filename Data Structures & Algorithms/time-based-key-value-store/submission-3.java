class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());

        int left = 0, right = list.size() - 1;
        String value = "";
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(list.get(mid).getKey() <= timestamp) {
                value = list.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return value;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V val;

        public Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }
}
