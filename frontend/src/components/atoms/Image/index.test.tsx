import { render, screen } from "@testing-library/react";
import ImageComponent from "./index";
import facebook from "../../../../public/assets/images/facebook.svg";
import graph from "../../../../public/assets/images/graph.svg";
import "@testing-library/jest-dom";

describe("ImageComponent", () => {
  it("renders the image with the provided source", () => {
    const src = facebook;
    render(<ImageComponent src={src} />);

    const imageElement = screen.getByTestId("image");

    expect(imageElement).toBeInTheDocument();

  });

  it("sets the width and height attributes if provided", () => {
    const src = graph;
    const width = "200";
    const height = "150";
    render(<ImageComponent src={src} width={width} height={height} />);

    const imageElement = screen.getByTestId("image");

    expect(imageElement).toHaveAttribute("width", width);
    expect(imageElement).toHaveAttribute("height", height);
  });
});
