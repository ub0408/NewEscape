package room;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {

	@Override
	public List<RoomDTO> list(Integer branch_id) {
		List list = Room.listRoom(branch_id);
		return list;
	}

	@Override
	public List<RoomDTO> getRoom(Integer room_id) {
		List list = Room.getRoom(room_id);
		return list;
	}

	@Override
	public void insertRoom(RoomDTO dto) {
		Room.insertRoom(dto);
	}

	@Override
	public void deleteRoom(Integer room_id) {
		Room.deleteRoom(room_id);
		
	}

}
