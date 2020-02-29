package travel.service;

public interface FavoriteService {
    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    public boolean isFavorite(String rid, int uid);
}
