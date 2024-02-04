import { render } from "@testing-library/react";
import MuiTypography from "."; 

test("renders Typography", () => {
    const { getByTestId } = render(<MuiTypography text="hello" variant="h1" />);
    expect(getByTestId("typography-component")).toBeDefined();
});
