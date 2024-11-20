package ro.OnlineLibrary.MySpringApi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_Services implements IUserServices{
    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public void borrow_book(User utilizator, Book carte) {

    }

    @Override
    public void return_book(User utilizator, Book carte) {

    }
}
